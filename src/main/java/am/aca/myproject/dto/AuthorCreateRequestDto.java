package am.aca.myproject.dto;

public class AuthorCreateRequestDto {

    private String authorName;


    public AuthorCreateRequestDto() {
    }

    public AuthorCreateRequestDto(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
