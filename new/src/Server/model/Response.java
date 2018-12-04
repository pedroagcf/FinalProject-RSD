package Server.model;


public class Response {
	
    private String msg;
    private String data;

    public Response (String message, String data) {
        this.msg = message;
        this.data = data;
    }

    public Response(String message){
        this.msg = message;
//        this.data = null;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

	@Override
	public String toString() {
		return "Response [msg=" + this.msg + ", data=" + this.data + "]";
	}
    
    

}
