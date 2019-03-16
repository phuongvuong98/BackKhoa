// napi.h la thu vien giup ta truy cap masco, class va function
#include <napi.h>
#include "Samples/functionexample.h"
#include "Samples/classexample.h"

// initAll nhan env: doan ma truyen vao cho N-API
//         nhan export: de xuat ra ham va class thong qua N-API
Napi::Object InitAll(Napi::Env env, Napi::Object exports) {
  functionexample::Init(env, exports);
  return ClassExample::Init(env, exports);
}

// macro cho truyen param module name va registerfunction
NODE_API_MODULE(NODE_GYP_MODULE_NAME, InitAll)
