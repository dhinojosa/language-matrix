package com.evolutionnext.concurrency.livelock;

public class Police {
    private boolean moneySent = false;

    public void giveRansom(Criminal criminal) {
        while (!criminal.isHostageReleased()) {
            System.out.println(
                "Police: waiting criminal to release hostage");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("Police: sent money");
        this.moneySent = true;
    }

    public boolean isMoneySent() {
        return this.moneySent;
    }
}
