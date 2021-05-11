package com.yk.vote.controller;

import com.yk.vote.po.User;
import com.yk.vote.po.UserVote;
import com.yk.vote.po.VoteInfo;
import com.yk.vote.po.VoteOption;
import com.yk.vote.po.custom.VoteInfoCustom;
import com.yk.vote.service.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@Controller
public class VoteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VoteController.class);

    @Autowired
    private VoteService voteService;

    @RequestMapping(value = "/addVote")
    public String addVote(@RequestParam(value = "name") String name, @RequestParam(value = "type") Integer type, @RequestParam(value = "options") String[] options) throws Exception {
        String vid = UUID.randomUUID().toString();
        VoteInfo vote = new VoteInfo(vid, name, type);
        List<VoteOption> optionList = new ArrayList<>();
        for(String option: options) {
            optionList.add(new VoteOption(null, vid, option));
        }
        voteService.saveVote(vote, optionList);
        return "redirect:queryAllVotes";
    }

    @RequestMapping(value = "/queryAllVotes")
    public String queryAllVotes(Model model) throws Exception {
        List<VoteInfoCustom> voteList = voteService.queryAllVotes();
        model.addAttribute("voteList", voteList);
        return "votelist";
    }

    @RequestMapping(value = "/queryVote")
    public String queryVote(Model model, HttpSession session, @RequestParam(value = "vid") String vid) throws Exception {
        VoteInfoCustom voteInfoCustom = voteService.queryVoteByVid(vid);
        model.addAttribute("voteInfo", voteInfoCustom);
        return "vote";
    }

    @RequestMapping(value = "/queryVoteResult")
    public String queryVoteResult(Model model, HttpSession session, @RequestParam(value = "vid") String vid) throws Exception {
        VoteInfoCustom voteInfoCustom = voteService.queryVoteByVid(vid);
        model.addAttribute("voteInfo", voteInfoCustom);
        User user = (User) session.getAttribute("currentUser");
        if(user != null) {
            List<String> votedList = voteService.queryVoteByUserNameAndVid(user.getUserName(), vid);
            if(votedList.size() > 0) {
                model.addAttribute("voted", 1);
            } else {
                model.addAttribute("voted", 0);
            }
        } else {
            model.addAttribute("voted", 0);
        }
        return "view";
    }

    @RequestMapping(value = "/voting", method = {RequestMethod.POST})
    public String voting(HttpSession session, @RequestParam(value = "vid") String vid, @RequestParam(value = "options") Integer[] options) {
        User user = (User) session.getAttribute("currentUser");
        if(user == null) {
            return "login";
        }
        List<UserVote> userVoteList = new ArrayList<>();
        for(Integer oid: options) {
            userVoteList.add(new UserVote(null, user.getUserName(), oid));
        }
        voteService.saveUserVoteList(userVoteList);
        return "redirect:queryVoteResult?vid="+vid;
    }

}
