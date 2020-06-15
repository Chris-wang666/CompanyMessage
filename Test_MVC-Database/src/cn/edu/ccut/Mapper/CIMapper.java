package cn.edu.ccut.Mapper;

import cn.edu.ccut.PO.Company;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CIMapper {
    @Insert("insert into company_message(name , address , phone) values(#{name},#{address},#{phone})")
    @Options(useGeneratedKeys = true)
    int insertCompany (Company c);

    @Delete("delete from company_message where id = #{id}")
    int deleteById(int id);

    @Update(" update company_message set name=#{name},address=#{address},phone=#{phone} where id=#{id}")
    int updateLoginById(Company c);

    @Select("select * from company_message")
    @Results({@Result(id = true, column = "id", property = "id")})
    List<Company> selectAllCompany();
}
