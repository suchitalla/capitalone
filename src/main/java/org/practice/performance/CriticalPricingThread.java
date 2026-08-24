package org.practice.performance;

import net.openhft.affinity.AffinityLock;
import net.openhft.affinity.CpuLayout;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

//CPU Affinity Lock
public class CriticalPricingThread {
    public void startEngine() {
        CpuLayout layout = AffinityLock.cpuLayout();
        System.out.println("Sockets: " + layout.sockets());
        System.out.println("Cores per socket: " + layout.coresPerSocket());
        System.out.println("Threads per core: " + layout.threadsPerCore());

        // Detailed breakdown
        System.out.println(layout.toString());

        // Acquire a lock on a specific CPU core
        try (AffinityLock al = AffinityLock.acquireLock()) {
            System.out.println("Thread pinned to core: " + al.cpuId());

            while (true) {
                // Your ultra-low-latency pricing loop goes here
                // No OS context switching will interrupt this core

            }
        }// al.release() is called automatically here
    }

    public void writeToSharedMemory() throws Exception {
        RandomAccessFile file = new RandomAccessFile("/dev/shm/market_data", "rw");
        //When you execute this, you are telling the Operating System:
        // "Take this file on the disk and map it directly into the application's virtual memory space."
        MappedByteBuffer buffer = file.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 1024 * 1024);

        // Writing here is effectively writing directly to RAM that
        // another process can see instantly (sub-microsecond latency).
        buffer.putDouble(0, 145.50);
    }

    public static void main(String args[]){
        CriticalPricingThread cp = new CriticalPricingThread();
        cp.startEngine();
    }
}
