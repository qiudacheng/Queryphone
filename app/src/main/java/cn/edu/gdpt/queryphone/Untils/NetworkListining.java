package cn.edu.gdpt.queryphone.Untils;

public interface NetworkListining<T> {
    public void BackResultSuccess(T bean, int code);
    public void BackResultFail(Exception errow);
    public void tostring(String responseString);

}
