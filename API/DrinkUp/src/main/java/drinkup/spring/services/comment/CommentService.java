package drinkup.spring.services.comment;


import drinkup.spring.domain.Comment;

public interface CommentService {
    Iterable<Comment> listAllComments();

    Comment getCommentById(int id);

    Comment saveComment(Comment comment);

    void deleteComment(int id);
}
