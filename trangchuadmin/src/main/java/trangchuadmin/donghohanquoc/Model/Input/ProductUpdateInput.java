package trangchuadmin.donghohanquoc.Model.Input;

import lombok.Data;
import trangchuadmin.donghohanquoc.Model.Entity.BrandEntity;

import java.util.Date;
import java.util.List;

@Data
public class ProductUpdateInput {
    private Integer id;
    private String productname;
    private String image;
    private Integer price;
    private String description;
    private Integer status;
    private BrandEntity brandEntity;
    private Integer quantitysold;
    private Integer quantityremaining;
    private Date updatedat;
    private String updatedby;
    private List<ProductAtributeInput> productAtributeInputList;
    private List<ProductCategoriesInput> productCategoriesInputList;
}
