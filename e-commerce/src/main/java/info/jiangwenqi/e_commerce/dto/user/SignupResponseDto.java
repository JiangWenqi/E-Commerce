package info.jiangwenqi.e_commerce.dto.user;

/**
 * @author wenqi
 */
public class SignupResponseDto {
    public Integer getStatus() {
        return status;
    }

    public SignupResponseDto(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private Integer status;
    private String message;
}
