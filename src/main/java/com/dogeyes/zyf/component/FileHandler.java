package com.dogeyes.zyf.component;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件处理器
 *
 * @author ZYF
 * @create 2021-4-13 9:53
 */
@Component
@Log4j2
public class FileHandler {

    @Value("${web.upload-path}")
    private String uploadPath;

    @Value("${web.movie-post-path}")
    private String moviePostPath;

    @Value("${web.avatar-path}")
    private String avatarPath;

    public static final String MOVIE_POST = "MOVIE_POST";
    public static final String AVATAR = "AVATAR";
    public static final String DEFAULT_FILE = "AVATAR";


    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    /**
     * 转换为本地路径
     *
     * @param fileURL 文件的网络链接
     * @param type    文件类型
     * @return 本地路径
     */
    public String toLocalPath(String fileURL, String type) {
        String localPath = "";
        try {
            localPath = DownloadFile(fileURL, type);
        } catch (MalformedURLException e) {
            System.out.println("解析链接失败：" + fileURL);
        }
        return localPath;
    }

    /**
     * 下载网络文件
     *
     * @param fileURL 文件的网络链接
     * @param type    文件类型
     * @return 本地路径
     */
    private String DownloadFile(String fileURL, String type) throws MalformedURLException {
        URL url = new URL(fileURL);
        String fileName = getFileName(fileURL);
        String localPath = uploadPath;

        if (MOVIE_POST.equals(type)) localPath += moviePostPath;
        else if (AVATAR.equals(type)) localPath += avatarPath;

        try {
            File f = new File(localPath + fileName);
            FileUtils.copyURLToFile(url, f);
            localPath = f.getAbsolutePath();
        } catch (IOException e) {
            System.out.println("下载失败：" + fileURL);
            localPath += "default.jpg";
            System.out.println("转为默认图片：" + localPath);
        }

        return localPath;
    }

    /**
     * 将前端上传的文件保存到本地
     *
     * @param file 文件
     * @return 文件保存路径
     */
    public String upload(MultipartFile file) {
        if (file.isEmpty()) {
            log.error("文件为空");
            return null;
        }

        // aaa.jpg
        String originalFilename = file.getOriginalFilename();
        // jpg
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf('.'));
        // aaa
        String fileName = originalFilename.substring(0, originalFilename.lastIndexOf('.'));
        log.info("上传文件名：" + fileName + "类型：" + suffixName);

        // aaa6565646132.jpg
        fileName += System.currentTimeMillis() + suffixName;
        log.info("重命名后文件名：" + fileName);


        String filePath = uploadPath + avatarPath;
        File dest = new File(filePath, fileName);

        try {
            file.transferTo(dest);
            String localPath = filePath + fileName;
            log.info("上传到：" + localPath);
            return localPath;
        } catch (IOException e) {
            log.error("上传失败：" + e.getMessage());
            return null;
        }
    }

    private String getFileName(String fileURL) {
        String name = "";
        int idx = fileURL.lastIndexOf('/');
        if (idx > 0) {
            name = fileURL.substring(idx + 1);
            if (name.trim().length() > 0) {
                return name;
            }
        }
        return name;
    }
}


