package com.taos.up.baseproject.thread;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LearnExecutor {
    private ExecutorService executorService;
    private Runnable runnable;

    public ExecutorService getExecutorService() {
        return executorService;
    }


    public Runnable getRunnable() {
        return runnable;
    }


    public static class Builder {
        private LearnExecutor learnExecutor = new LearnExecutor();
        private List<Runnable> runnables = new ArrayList<>();

        public LearnExecutor build() {
            return learnExecutor;
        }

        public Builder setRunnable(Runnable runnable) {
            learnExecutor.runnable = runnable;
            runnables.add(runnable);
            return this;
        }

        public Builder setExecutorService(ExecutorService executorService) {
            learnExecutor.executorService = executorService;
            return this;
        }

        public void execute() {
            for (Runnable r : runnables) {
                learnExecutor.executorService.execute(r);
            }

        }
    }

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("无核心线程");
            }
        });
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("超时时间为60s");
            }
        });


        ExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(5);
        scheduledExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("核心线程为5 而非核心线程数是没有限制的,并且当非核心线程闲置时会被立即回收." +
                        "主要用于执行定时任务和具有固定周期的重复任务.");
            }
        });

        ExecutorService executorService = new PriorityExecutor(5, false);
        for (int i = 0; i < 20; i++) {
            PriorityRunnable priorityRunnable = new PriorityRunnable(Priority.NORMAL, new Runnable() {
                @Override
                public void run() {
//                    Log.e(TAG, Thread.currentThread().getName()+"优先级正常");
                }
            });
            if (i % 3 == 1) {
                priorityRunnable = new PriorityRunnable(Priority.HIGH, new Runnable() {
                    @Override
                    public void run() {
//                        Log.e(TAG, Thread.currentThread().getName()+"优先级高");
                    }
                });
            } else if (i % 5 == 0) {
                priorityRunnable = new PriorityRunnable(Priority.LOW, new Runnable() {
                    @Override
                    public void run() {
//                        Log.e(TAG, Thread.currentThread().getName()+"优先级低");
                    }
                });
            }
            executorService.execute(priorityRunnable);
        }
    }
}
