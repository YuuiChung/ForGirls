package cn.it.shop.util;

import cn.it.shop.model.FileImage;

public interface FileUpload {

	public String uploadFile(FileImage fileImage);

	public String[] getBankImage();
}