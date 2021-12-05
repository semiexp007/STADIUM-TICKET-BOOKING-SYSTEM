package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.akmadheshiya.qui.DataBinderMapperImpl());
  }
}
