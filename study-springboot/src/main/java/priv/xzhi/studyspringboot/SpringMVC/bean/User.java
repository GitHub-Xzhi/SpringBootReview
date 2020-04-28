package priv.xzhi.studyspringboot.SpringMVC.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

@Data
@TableName(value = "user")
public class User implements Serializable {
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "userName")
    private String userName;

    @TableField(value = "note")
    private String note;

    private static final long serialVersionUID = 1L;

    public static final String COL_USERNAME = "userName";

    public static final String COL_NOTE = "note";
}