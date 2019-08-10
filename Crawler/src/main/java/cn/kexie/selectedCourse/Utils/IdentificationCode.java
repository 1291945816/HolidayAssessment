package cn.kexie.selectedCourse.Utils;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Component;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 传递原始照片的地址，返回识别后的验证码
 */
@Component
public class IdentificationCode {

    public static String process() throws Exception {

        String ocrResult = "D:\\javaCode\\kexieHolidayAssessment\\src\\main\\resources\\Image\\Gain.png";
        String file = "D:\\javaCode\\kexieHolidayAssessment\\src\\main\\resources\\Image\\screen.png";

        //降噪顺便灰度化  提高识别度
        IdentificationCode.removeBackground(file,ocrResult);

       //读取图片进入缓存流
        BufferedImage image = ImageIO.read(new File(ocrResult));

        ITesseract instance = new Tesseract();
        instance.setLanguage("eng");
        instance.setDatapath("D:\\javaCode\\kexieHolidayAssessment\\src\\main\\resources\\tessdata");
        try{
            String result = instance.doOCR(image);
            result.trim().replaceAll("[^0-9]","");
            return result;

        }catch(TesseractException e){
            System.err.println(e.getMessage());
        }
        return "";
    }
    /**
     *
     * @param imgUrl 原始图片地址
     * @param resUrl  降噪之后的图片的地址
     */
    public  static void removeBackground(String imgUrl,String resUrl){
        //定义一个临界阈值
        int threshold = 450;
        try{
            BufferedImage image = ImageIO.read(new File(imgUrl));
            int height = image.getHeight();
            int width = image.getWidth();
            for(int i = 1;i < width;i++){
                for(int x = 0;x < width;x++){
                    for(int y = 0;y < height;y++){
                        Color color = new Color(image.getRGB(x,y));
                        //System.out.println("red:"+color.getRed()+" |green: "+color.getGreen()+" | bluee:"+color.getBlue());
                        int num = color.getRed()+color.getBlue()+color.getGreen();
                        if(num >= threshold){
                            image.setRGB(x,y,Color.WHITE.getRGB());
                        }
                    }

                }

            }
            for(int i = 1;i < width;i++){
                Color color1 = new Color(image.getRGB(i,1));
                int num1 = color1.getRed()+color1.getGreen()+color1.getBlue();
                for(int x = 0;x <width;x++){
                    for(int y = 0;y < height;y++){
                        Color color = new Color(image.getRGB(x,y));
                        int num = color.getRed()+color.getGreen()+color.getBlue();
                        if(num == num1){
                            image.setRGB(x,y,Color.BLACK.getRGB());
                        }else {
                            image.setRGB(x,y,Color.WHITE.getRGB());
                        }
                    }

                }
            }
            File file = new File(resUrl);
            if(!file.exists()){
                File dir = file.getParentFile();
                if(!dir.exists()){
                    dir.mkdir();
                }
                try{
                    file.createNewFile();

                }catch (IOException e){
                    e.printStackTrace();
                }

            }

            ImageIO.write(image,"png",file);



        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
