package com.cxg.eip.controller;

import com.cxg.eip.model.pojo.Book;
import com.cxg.eip.model.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    //获取图书列表
    @RequestMapping("/book")
    public String getbooks(Model model){
        List<Book> books = bookService.getBooks();
        model.addAttribute("books",books);
        return "book";
    }
    //图书下载
    @RequestMapping("/bookDown/{bookName}")
    public ResponseEntity<byte[]> bookDown(@PathVariable(value = "bookName") String bookName, HttpSession session) throws Exception {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/books/"+bookName+".txt");
        System.out.println(realPath);
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.txt");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,
                statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }
    //图书上传
    @RequestMapping(value = "/bookUp",method = RequestMethod.POST)
    public String bookUp(MultipartFile book, HttpSession session) throws Exception {
        //获取上传的文件的文件名
        String fileName = book.getOriginalFilename();
        //获取服务器中books目录的路径
        ServletContext servletContext = session.getServletContext();
        String booksPath = servletContext.getRealPath("/static/books");
        System.out.println(booksPath);
        File file = new File(booksPath);
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath = booksPath + File.separator + fileName;
        //实现上传功能
        book.transferTo(new File(finalPath));

        String bookName = StringUtils.substringBeforeLast(fileName, ".");

        //数据库添加图书记录
        bookService.addBook(bookName);



        return "redirect:/book";
    }

}
