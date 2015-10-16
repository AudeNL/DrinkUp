package drinkup.spring.controllers;

import drinkup.spring.domain.Comment;
import drinkup.spring.services.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* REVOIR POUR L'ID */

@Controller
public class CommentController {

    private CommentService commentService;

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("comments", commentService.listAllComments());
        return "comments";
    }

    @RequestMapping("comment/{id}")
    public String showComment(@PathVariable int id, Model model){
        model.addAttribute("comment", commentService.getCommentById(id));
        return "commentshow";
    }

    @RequestMapping("comment/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("comment", commentService.getCommentById(id));
        return "commentform";
    }

    @RequestMapping("comment/new")
    public String newComment(Model model){
        model.addAttribute("comment", new Comment());
        return "commentform";
    }

    @RequestMapping(value = "comment", method = RequestMethod.POST)
    public String saveComment(Comment comment){
        commentService.saveComment(comment);
        return "redirect:/comment/" + comment.getIdCustomer();
    }

    @RequestMapping("comment/delete/{id}")
    public String delete(@PathVariable int id){
        commentService.deleteComment(id);
        return "redirect:/comments";
    }

}
