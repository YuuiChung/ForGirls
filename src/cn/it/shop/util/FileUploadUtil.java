package cn.it.shop.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.UUID;
import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import cn.it.shop.model.FileImage;

@Component("fileUpload")
public class FileUploadUtil implements FileUpload {

	// 注入"值"  配置文件的加载存储到 applicationContext-public.xml 中
	@Value("#{public.basePath+public.filePath}")
	private String filePath = "";

	@Value("#{public.basePath+public.bankPath}")
	private String bankPath = "";

	public String[] getBankImage() {
		return new File(bankPath).list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {

				return name.endsWith(".gif");
			}
		});
	}

	private String getFileExt(String fileName) {
		return FilenameUtils.getExtension(fileName);
	}

	private String newFileName(String fileName) {
		String ext = getFileExt(fileName);
		return UUID.randomUUID().toString() + "." + ext;
	}

	public String uploadFile(FileImage fileImage) {
		String pic = newFileName(fileImage.getFilename());
		try {
			FileUtil.copyFile(fileImage.getFile(), new File(filePath, pic));
			return pic;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			fileImage.getFile().delete();
		}

	}
}
