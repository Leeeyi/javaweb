package admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serial;
import java.util.List;
import java.util.Objects;

import Bean.User;
import org.apache.commons.io.IOUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utils.Upload;
import Bean.Goods;
import service.GoodsService;
import exception.AddGoodsException;

public class AddGoods extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Goods goods = new Goods();
        User user = (User) request.getSession().getAttribute("user");
        String id = user.getId();
        goods.setIdofsalesman(id);
        DiskFileItemFactory dfif = new DiskFileItemFactory();
        // 设置临时文件存储位置
        dfif.setRepository(new File(this.getServletContext().getRealPath(
                "/temp")));
        // 设置上传文件缓存大小为10m
        dfif.setSizeThreshold(1024 * 1024 * 10);
        // 创建上传组件
        ServletFileUpload upload = new ServletFileUpload(dfif);
        // 处理上传文件中文乱码
        upload.setHeaderEncoding("utf-8");
        try {
            // 解析request得到所有的FileItem
            List<FileItem> items = upload.parseRequest(request);
            // 遍历所有FileItem
            for (FileItem item : items) {
                // 判断当前是否是上传组件
                if (item.isFormField()) {
                    // 不是上传组件
                    String fieldName = item.getFieldName(); // 获取组件名称
                    String value = item.getString("utf-8"); // 解决乱码问题
                    if (Objects.equals(fieldName, "name")){goods.setName(value);}
                    if (Objects.equals(fieldName, "kind")){goods.setKind(value);}
                    if (Objects.equals(fieldName, "price")){goods.setPrice(value);}
                    if (Objects.equals(fieldName, "num")){goods.setNum(Integer.parseInt(value));}
                    if (Objects.equals(fieldName, "description")){goods.setDescription(value);}
                } else {
                    // 是上传组件
                    // 得到上传文件真实名称
                    String fileName = item.getName();
                    fileName = Upload.subFileName(fileName);

                    // 得到随机名称
                    String randomName = Upload
                            .generateRandonFileName(fileName);

                    // 得到随机目录
                    String randomDir = Upload
                            .generateRandomDir(randomName);
                    // 图片存储父目录
                    String path="C:/img"+randomDir;
                    File parentDir = new File(path);
                    // 验证目录是否存在，如果不存在，创建出来
                    if (!parentDir.exists()) {
                        parentDir.mkdirs();
                    }
                    String imgurl = randomDir + "/" + randomName;

                    goods.setPicURL(imgurl);

                    IOUtils.copy(item.getInputStream(), new FileOutputStream(
                            new File(parentDir, randomName)));
                    item.delete();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        // 调用service完成注册操作。
        GoodsService service = new GoodsService();
        try {
            service.addProduct(goods);
        } catch (AddGoodsException e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/AddSuccess.jsp");
    }
}
