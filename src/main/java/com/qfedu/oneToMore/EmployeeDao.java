package com.qfedu.oneToMore;

public interface EmployeeDao {
    public void selectAllById(Integer id);
    public Employee select1(Integer id);
    public Employee selectByEid(Integer id);
}
