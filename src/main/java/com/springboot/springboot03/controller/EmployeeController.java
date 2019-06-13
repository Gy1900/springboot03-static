package com.springboot.springboot03.controller;

import com.springboot.springboot03.dao.DepartmentDao;
import com.springboot.springboot03.dao.EmployeeDao;
import com.springboot.springboot03.entities.Department;
import com.springboot.springboot03.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by gy on 2019/5/31 0031 20:01
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 查询员工列表
     * 获取所有员工，并将它们放在请求域中model
     * model.addAttribute(String,Object)---往前台传数据，可以传对象，可以传List，通过el表达式 ${}可以获取到，在return  "/emp/list"；跳转的index.html中通过"@{/emp}"获取collection
     */

    @GetMapping("/emps")
    public String SearchEmployee(Model model) {
        Collection<Employee> collection = employeeDao.getAll();
        model.addAttribute("emps", collection);
        return "emp/list";
    }


    /**
     * 添加员工
     * springMVC会将请求参数和入参一一绑定，要求请求参数和javabean的参数名一样
     * get + post
     */

    @GetMapping("/emp")
    public String addEmployee(Model model) {
        Collection<Department> collection = departmentDao.getDepartments();
        model.addAttribute("depts", collection);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmployeePost(Employee employee, BindingResult bindingResult) {
        employeeDao.save(employee);
        // 转到list.html，显示添加之后的所有员工
        //redirect： 重定向; /转到当前目录
        //forward: 转发
        return "redirect:/emps";
    }

    /**
     * 修改员工
     * get员工id，并在页面回显  add.html
     * get + put
     */

    @GetMapping(value = "/emp/{id}")
    public String modifyEmployeeGet(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        //返回部门
        Collection<Department> collection = departmentDao.getDepartments();
        model.addAttribute("depts", collection);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String modifyEmployeePut(Employee employee) {
        return "redirect:/emps";
    }

    /**
     * 删除员工
     * 因为 html中<form th:action="@{/emp/}+${emp.id}" method="post">
     * 是post请求，所以需要 @PostMapping("/emp/{id}")，对应请求类型
     */
    @PostMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
