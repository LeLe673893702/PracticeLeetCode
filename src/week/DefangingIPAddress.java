package week;

/**
 * IP 地址无效化
 *
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 */
public class DefangingIPAddress {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
