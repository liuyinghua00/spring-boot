package com.yinghua.liu.blog.blog.controller;

public class TestXmlBean {
	 private int timeout;
	  private int batch;
	 
	  public void setTimeout(int timeout) {
	    this.timeout = timeout;
	  }

	  public void setBatch(int batch) {
	    this.batch = batch;
	  }
	 
	  public int getTimeout() {
	    return timeout;
	  }
	 
	  public int getBatch() {
	    return batch;
	  }

	@Override
	public String toString() {
		return "TestXmlBean [timeout=" + timeout + ", batch=" + batch + "]";
	}
	  
}
