package trangchuadmin.donghohanquoc.Model.Output;


import lombok.Data;
import trangchuadmin.donghohanquoc.Model.Entity.ProductAtributeEntity;
import trangchuadmin.donghohanquoc.Utils.Utils;

@Data
public class Cart{
    private int id;
    private int count;
    private int productId;
    private int sizeId;
    private ProductAtributeEntity productDetail;
    public String getAmount() {
        int money = (int) (this.productDetail.getProductentity().getPrice() * this.count);
        return Utils.currencyMoney(money);
    }
}
