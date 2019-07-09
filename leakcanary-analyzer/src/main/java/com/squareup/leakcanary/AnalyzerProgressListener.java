package com.squareup.leakcanary;

import android.support.annotation.NonNull;

public interface AnalyzerProgressListener {

  @NonNull AnalyzerProgressListener NONE = new AnalyzerProgressListener() {
    @Override public void onProgressUpdate(@NonNull Step step) {
    }
  };

  // These steps should be defined in the order in which they occur.
  enum Step {
    READING_HEAP_DUMP_FILE,// 读取堆转储文件
    PARSING_HEAP_DUMP,// 解析堆转储文件
    DEDUPLICATING_GC_ROOTS,// 彻底删除 GC_ROOT
    FINDING_LEAKING_REF,// 寻找内存泄漏引用
    FINDING_SHORTEST_PATH,// 寻找最短路径
    BUILDING_LEAK_TRACE,// 构建内存泄漏路径图
    COMPUTING_DOMINATORS,// 计算
    COMPUTING_BITMAP_SIZE,// 计算
  }

  void onProgressUpdate(@NonNull Step step);
}