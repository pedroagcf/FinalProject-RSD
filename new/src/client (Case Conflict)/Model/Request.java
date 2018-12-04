package Client.Model;

public class Request {
	private String method;
	private String data;

	
	public Request(String method, String data) {
		this.method = method;
		this.data = data;
	}
	
	public Request(String method) {
		this.method = method;
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}
	
}
