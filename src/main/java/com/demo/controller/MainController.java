package com.demo.controller;

import com.demo.model.Student;
import com.demo.service.StudentServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class MainController {

    //@Autowired
    StudentServise studentServise;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listStudents(ModelMap modelMap){
        List<Student> students = studentServise.findAllStudents();
        modelMap.addAttribute("students", students);
        return "allstudents";
    }



    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newStudent(ModelMap modelMap){
        Student student = new Student();
        modelMap.addAttribute("student", student);
        modelMap.addAttribute("edit", false);
        return "registration";
    }




    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveStudent(@Valid Student student, BindingResult result, ModelMap modelMap){
        if (result.hasErrors()){
            return "registration";
        }
        if (!studentServise.isStudentCodeUnique(student.getId(), student.getCode())){
            FieldError codeError = new FieldError("Student", "code",
                    messageSource.getMessage("non.unique.code", new String[]{student.getCode()},
                            Locale.getDefault()));
            result.addError(codeError);
            return "registration";
        }

        studentServise.saveStudent(student);

        modelMap.addAttribute("success", "Student" + student.getName() + " registered successfuly");

        return "success";
    }

    @RequestMapping(value = {"/edit-{code)-student"}, method = RequestMethod.POST)
    public String updateStudent(@Valid Student student, BindingResult result, ModelMap modelMap,
                                @PathVariable String code){
        if (result.hasErrors()){
            return "registration";
        }
        if (!studentServise.isStudentCodeUnique(student.getId(), student.getCode())){
            FieldError codeError = new FieldError("Student","code",
                    messageSource.getMessage("non.unique.code", new String[]{student.getCode()},Locale.getDefault()));
            result.addError(codeError);
            return "registration";
        }

        studentServise.updateStudent(student);
        modelMap.addAttribute("success", "Student "+student.getName() + " updated successfuly");
        return "success";

    }


    @RequestMapping(value = {"/edit-{code}-student"}, method = RequestMethod.GET)
    public String editStudent(@PathVariable String code, ModelMap modelMap){
        Student student = studentServise.findStudentByCode(code);
        modelMap.addAttribute("student", student);
        modelMap.addAttribute("edit", true);
        return "registration";
    }

    @RequestMapping(value = {"/delete-{code}-student"}, method = RequestMethod.GET)
    public String deleteStudent(@PathVariable String code){
        studentServise.deleteStudent(code);
        return "redirect:/list";
    }
}
