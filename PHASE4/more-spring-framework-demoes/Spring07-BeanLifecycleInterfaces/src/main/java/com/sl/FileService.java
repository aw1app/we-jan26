package com.sl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class FileService implements InitializingBean, DisposableBean {
    private String fileName;

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    @Override
    public void afterPropertiesSet() {
        System.out.println("[Interface Lifecycle] FileService initialized. File: " + fileName);
    }

    @Override
    public void destroy() {
        System.out.println("[Interface Lifecycle] FileService destroyed. Saved file: " + fileName);
    }
}