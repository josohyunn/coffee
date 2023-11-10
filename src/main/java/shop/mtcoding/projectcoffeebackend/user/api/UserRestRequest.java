package shop.mtcoding.projectcoffeebackend.user.api;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import shop.mtcoding.projectcoffeebackend.user.User;

public class UserRestRequest {
    @Getter
    @Setter
    @ToString
    public static class JoinDTO {

        @NotEmpty
        private String loginId;

        @NotEmpty
        @Size(min = 8, max = 20, message = "8에서 20자 이내여야 합니다.")
        @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!~`<>,./?;:'\"\\[\\]{}\\\\()|_-])\\S*$", message = "영문, 숫자, 특수문자가 포함되어야하고 공백이 포함될 수 없습니다.")
        private String password;

        @NotEmpty
        @Pattern(regexp = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", message = "이메일 형식으로 작성해주세요")
        private String email;

        @NotEmpty
        private String userName;

        @NotEmpty
        private String phoneNumber;
        @NotNull
        private int manager;

        public User toEntity() {
            return User
                    .builder()
                    .loginId(loginId)
                    .password(password)
                    .userName(userName)
                    .phoneNumber(phoneNumber)
                    .email(email)
                    .manager(manager)
                    .build();
        }
    }

    @Getter
    @Setter
    public static class LoginDTO {
        @NotEmpty
        // @Pattern(regexp = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", message = "이메일
        // 형식으로 작성해주세요")
        private String loginId;

        @NotEmpty
        @Size(min = 8, max = 20, message = "8에서 20자 이내여야 합니다.")
        @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!~`<>,./?;:'\"\\[\\]{}\\\\()|_-])\\S*$", message = "영문, 숫자, 특수문자가 포함되어야하고 공백이 포함될 수 없습니다.")
        private String password;
    }

    @Getter
    @Setter
    public static class PwdUpdateDTO {
        // private String presentPwd;
        private String loginId;
        private String password;
    }
}
