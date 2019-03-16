#include <napi.h>

namespace functionexample {
    // Moi ham ta muon C++ xuat ra ta dat NAPI wrapping function va them init object
    std::string hello();

    // Moi wrapp function nhan param va return lai gia tri tu Napi namespace
    Napi::String HelloWrapped(const Napi::CallbackInfo& info);

    int add(int a, int b);
    Napi::Number AddWrapped(const Napi::CallbackInfo& info);

    Napi::Object Init(Napi::Env env, Napi::Object exports);
    
}
