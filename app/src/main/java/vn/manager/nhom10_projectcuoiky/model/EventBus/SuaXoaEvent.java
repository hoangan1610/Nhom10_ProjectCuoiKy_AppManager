package vn.manager.nhom10_projectcuoiky.model.EventBus;

import vn.manager.nhom10_projectcuoiky.model.SanPhamMoi;

public class SuaXoaEvent {
    public SuaXoaEvent(SanPhamMoi sanPhamMoi) {
        this.sanPhamMoi = sanPhamMoi;
    }

    SanPhamMoi sanPhamMoi;

    public SanPhamMoi getSanPhamMoi() {
        return sanPhamMoi;
    }

    public void setSanPhamMoi(SanPhamMoi sanPhamMoi) {
        this.sanPhamMoi = sanPhamMoi;
    }
}
