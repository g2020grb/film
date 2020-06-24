package org.gec.web;

import org.gec.entity.Filminfo;
import org.gec.entity.Filmtype;
import org.gec.service.FilmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FilmInfoController {

    @Autowired
    private FilmInfoService filmInfoService;
    private String filmname;
    private Integer typeid;
    private String actor;
    private String director;
    private Double smallprice;
    private Double bigprice;

    //票价
    private Double ticketprice;

    public List<Filminfo> getResult() {
        return result;
    }

    //电影list
    List<Filminfo> result;

    public void setFilmname(String filmname) {
        this.filmname = filmname;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setSmallprice(Double smallprice) {
        this.smallprice = smallprice;
    }

    public void setBigprice(Double bigprice) {
        this.bigprice = bigprice;
    }

    public void setTicketprice(Double ticketprice) {
        this.ticketprice = ticketprice;
    }

    @RequestMapping("/findFilms")
    public ModelAndView findFilms() throws Exception{
        Filmtype filmtype = new Filmtype();

        //选了类型
        if (typeid != 0){
            filmtype.setTypeid(typeid);
        }

        //电影条件
        Filminfo filminfo = new Filminfo(filmtype,filmname,actor,director,bigprice,smallprice);

        //查询
        result = filmInfoService.findAllInfo(filminfo);

        ModelAndView mv = new ModelAndView();
        mv.addObject("result",result);
        mv.setViewName("page/result");
        return mv;
    }

    @RequestMapping("/FilmAddServlet")
    public String FilmAddServlet() throws Exception{
        //电影类型
        Filmtype filmtype = new Filmtype();
        filmtype.setTypeid(typeid);

        //电影条件
        Filminfo filminfo = new Filminfo(filmtype,filmname,actor,director,bigprice,smallprice);
        //设置票价
        filminfo.setTicketprice(ticketprice);

        //查询
        filmInfoService.save(filminfo);

        return "add";
    }

}
