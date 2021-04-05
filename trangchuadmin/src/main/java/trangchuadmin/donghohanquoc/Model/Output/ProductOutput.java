package trangchuadmin.donghohanquoc.Model.Output;

import lombok.Data;
import trangchuadmin.donghohanquoc.Model.Entity.BrandEntity;

import java.util.Date;

@Data
public class ProductOutput {
    private Integer id;
    private String productname;
    private String image;
    private Integer price;
    private String description;
    private int status;
    private BrandEntity brandentity;
    private int quantitysold;
    private int quantityremaining;
    private Date createdat;
    private String createdby;
    private Date updatedat;
    private String updatedby;
    private String path;
    private String PriceStr;
}
