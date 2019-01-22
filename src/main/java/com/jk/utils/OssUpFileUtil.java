package com.jk.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OssUpFileUtil {
    /**
     * endpoint是访问OSS的域名。如果您已经在OSS的控制台上 创建了Bucket，请在控制台上查看域名。
     * 比如“http://2019-zcf.oss-cn-beijing.aliyuncs.com”，是错误的endpoint，请去掉其中的“2019-zcf”。
     */
    private static String endpoint = "https://oss-cn-beijing.aliyuncs.com";
    /**
     * accessKeyId和accessKeySecret是OSS的访问密钥，您可以在控制台上创建和查看，
     * 创建和查看访问密钥的链接地址是：https://ak-console.aliyun.com/#/。
     * 注意：accessKeyId和accessKeySecret前后都没有空格，从控制台复制时请检查并去除多余的空格。
     */
    private static String accessKeyId = "LTAIepSn1TBunImg";
    private static String accessKeySecret = "jMljldKm5pKKV23yJYApd1zoc6bsUK";
    /**
     * Bucket命名规范如下：只能包括小写字母，数字和短横线（-），必须以小写字母或者数字开头，长度必须在3-63字节之间。
     */
    private static String bucketName = "2019-zcf";
    /**
     * OSS文件夹名称
     */
    private static String firstHost = "images";
    /**
     * Object是OSS存储数据的基本单元，称为OSS的对象，也被称为OSS的文件。详细描述请参看“开发人员指南 > 基本概念 > OSS基本概念介绍”。
     * Object命名规范如下：使用UTF-8编码，长度必须在1-1023字节之间，不能以“/”或者“\”字符开头。
     */
    private static String firstKey = "my-first-key";


    /**
     * 文件上传
     * @param file
     * @return
     */
    public static Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file){
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //String dateStr = format.format(new Date());  //用来创建时间文件夹
        Map<String, Object> fileMap = new HashMap<>();
        //生成OSSClient
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try{
            // 判断Bucket是否存在
            if (ossClient.doesBucketExist(bucketName)){
                //System.out.println("您已经创建Bucket：" + bucketName + "。");
                try{
                    if(null != file){
                        //获取文件名
                        String fileName = file.getOriginalFilename();
                        if(!"".equals(fileName.trim())){
                            File newFile = new File(fileName);
                            FileOutputStream os = new FileOutputStream(newFile);
                            os.write(file.getBytes());
                            os.close();
                            //截取文件名的后缀名
                            String fileType = fileName.substring(fileName.lastIndexOf("."));
                            //新的文件名
                            String newName = UUID.randomUUID().toString().replace("-", "") + fileType;
                            //存入OSS路径
                            //String name = firstHost+"/"+(dateStr + "/" +newName);
                            String name = firstHost+"/"+newName;
                            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, name, newFile));
                            System.out.println("Object：" + result + "存入OSS成功。");
                            // 设置URL过期时间为100年，默认这里是int型，转换为long型即可
                            Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 100);
                            // 生成URL
                            URL url = ossClient.generatePresignedUrl(bucketName, name, expiration);
                            //System.out.println(url);
                            fileMap.put("name", newName); //生成新名称
                            fileMap.put("url", url); //生成OSS的URL路径
                            fileMap.put("fileName", fileName); //上传时的原名称
                            fileMap.put("fileUrl", newFile.getCanonicalPath()); //原名称生成在项目中的路径地址
                        }
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }else{
                //System.out.println("您的Bucket不存在，创建Bucket：" + bucketName + "。");
                // 创建Bucket
                ossClient.createBucket(bucketName);
            }
            // 查看Bucket信息
            //BucketInfo info = ossClient.getBucketInfo(bucketName);
            //System.out.println("Bucket " + bucketName + "的信息如下：");
            //System.out.println("\t数据中心：" + info.getBucket().getLocation());
            //System.out.println("\t创建时间：" + info.getBucket().getCreationDate());
            //System.out.println("\t用户标志：" + info.getBucket().getOwner());
        }catch (OSSException oe){
            oe.printStackTrace();
        }catch (ClientException ce) {
            ce.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
        return fileMap;
    }

    /**
     * @Author zhangchaunfei
     * @Description //TODO 文件下载
     * @Date 09:57 2019/1/10
     * @Param
     * @return
     **/
    public static String downloadFile(String fileName, HttpServletResponse response){
        //获取原文件地址  存在项目中的路径地址
       /* File directory = new File(fileName);
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        } */
        String sourceUrl = fileName ; //存在项目中的路径地址
        System.out.println(sourceUrl);
        if (sourceUrl != null) {
            //获取源文件
            File file = new File(sourceUrl);
            //文件下载
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }







}
