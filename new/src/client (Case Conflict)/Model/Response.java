package Client.Model;

public class Response {
	
	private String msg;
	private String data;
	
	public Response(String msg, String data) {
		this.msg = msg;
		this.data = data;
	}
	
	public Response(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	

}
