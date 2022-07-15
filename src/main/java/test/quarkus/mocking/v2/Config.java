package test.quarkus.mocking.v2;

public class Config {
    private Integer retryTimes = 10;

    public Integer getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(Integer retryTimes) {
        this.retryTimes = retryTimes;
    }
}
