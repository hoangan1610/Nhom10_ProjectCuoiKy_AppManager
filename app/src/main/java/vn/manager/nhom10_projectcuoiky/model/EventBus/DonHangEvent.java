package vn.manager.nhom10_projectcuoiky.model.EventBus;

import vn.manager.nhom10_projectcuoiky.model.DonHang;

public class DonHangEvent {
    DonHang donHang;

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }

    public DonHangEvent(DonHang donHang) {
        this.donHang = donHang;
    }
}
