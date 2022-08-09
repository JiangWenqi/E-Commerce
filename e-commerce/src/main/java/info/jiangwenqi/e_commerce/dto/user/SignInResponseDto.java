package info.jiangwenqi.e_commerce.dto.user;

/**
 * @author wenqi
 */
public class SignInResponseDto {
    private Integer status;
    private String message;

    public SignInResponseDto(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
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
}
