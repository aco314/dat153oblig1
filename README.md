# DAT153 oblig 1 and 2

Group members:
- Aleksandar Bibic
- Sindre Ryland

# Oblig 2 task 2:
**Test method playButtonOpensQuizActivity():**  
This test checks if pressing the "Play Quiz" button on the main activity opens the quiz activity.

Line 49: launches the MainActivity class.  
Line 50: clicks on the button to play the quiz. The view should change to the QuizAcitvity class.  
Line 51: checks if the QuizActivity class is displayed on the screen.
 
 &nbsp;
 
**Test method scoreUpdatesCorrectly1():**  
This test opens the quiz activity and chooses the correct answer. It tests if the score gets tracked correctly.  

Line 57: launches the QuizActivity class.  
Line 60: Casting the current activity to type QuizActivity, because we know it is.  
Line 61: References the current QuizCard displayed in the activity.  
Line 62: References the correct answer of this  QuizCard  
Line 64 to 66: References to the 3 possible Button alternatives in the quiz activity.  
Line 68 to 74: Clicks on the correct alternative  
Line 77: Checks if the TextView containing the score matches to "1 out of 1 correct".  

&nbsp;

**Test method scoreUpdatesCorrectly2():**  
The test class is configured to run the tests in a specific order, so scoreUpdatesCorrectly2 will always run after scoreUpdatesCorrectly1. This is because it depends on it.  
scoreUpdatesCorrectly2 does the same as scoreUpdatesCorrectly1, but chooses the wrong answer instead.  

The code is almost identical to scoreUpdatesCorrectly1, except that it clicks on a wrong alternative instead.  
And at the end it checks if the TextView matches "1 out of 2 correct".  

&nbsp;

**Test method addNewCardUpdatesDatabase():**  
This test checks if adding a new QuizCard correctly saves it in the Room database.  

Line 106: launches the DatabaseActivity class.  
Line 107: Casting the current activity to type DatabaseActivity.   
Line 110: Create a new list *sizes* with Integers. Each list element says how many QuizCard entries there are in the database.  
Line 112 to 118: Observing changes in the database for the QuizCard table. It is done through DatabaseActivity's viewModel.  
Line 113: If there is a change, the new amount of QuizCards will be added to the *sizes* list.  
Line 115 to 117: If a new QuizCard gets added, it tests if the size of the database table has increased by 1. Because the observing is an asynchronous function, these lines will be ran after a new QuizCard has been added.  
Line 120 to 121: Adds a new QuizCard to the database through one of DatabaseActivity's methods.  

![image](https://user-images.githubusercontent.com/21562012/222832723-6affdc0f-d4ab-403b-b208-0c8fb983c30a.png)
&nbsp;  

# Oblig 2 task 3:  
**APK's used for testing:**  
./app/build/intermediates/apk/androidTest/debug/app-debug-androidTest.apk  
./app/build/intermediates/apk/debug/app-debug.apk  

**Command to install and run test:**  
```adb shell am instrument -w -m -e package com.example.dat153oblig1 -e debug false com.example.dat153oblig1.test/androidx.test.runner.AndroidJUnitRunner```  

**Output:**  
```
�"�
(
classcom.example.dat153oblig1.UITest


current

idAndroidJUnitRunner


numtests
+
stream!
com.example.dat153oblig1.UITest:
!
testaddNewCardUpdatesDatabase
�b"�
(
classcom.example.dat153oblig1.UITest


current

idAndroidJUnitRunner


numtests


stream.
!
testaddNewCardUpdatesDatabase*�a--------- beginning of main
03-05 20:21:43.111 10162 14799 14820 W Settings: Setting always_finish_activities has moved from android.provider.Settings.System to android.provider.Settings.Global, returning read-only value.
--------- beginning of system
03-05 20:21:43.120  1000   591  1224 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x10008000 cmp=com.example.dat153oblig1/.DatabaseActivity} from uid 10162
03-05 20:21:43.121  1000   591  1224 D CompatibilityChangeReporter: Compat change id reported: 194480991; UID 10162; state: ENABLED
03-05 20:21:43.128  1000   591  1224 D CompatibilityChangeReporter: Compat change id reported: 174042980; UID 10162; state: DISABLED
03-05 20:21:43.128  1000   591  1224 D CompatibilityChangeReporter: Compat change id reported: 184838306; UID 10162; state: DISABLED
03-05 20:21:43.129  1000   591  1224 D CompatibilityChangeReporter: Compat change id reported: 185004937; UID 10162; state: DISABLED
03-05 20:21:43.129  1000   591  1224 D CompatibilityChangeReporter: Compat change id reported: 181136395; UID 10162; state: DISABLED
03-05 20:21:43.129  1000   591  1224 D CompatibilityChangeReporter: Compat change id reported: 174042936; UID 10162; state: DISABLED
03-05 20:21:43.131  1000   591  1224 D CompatibilityChangeReporter: Compat change id reported: 197654537; UID 10162; state: ENABLED
03-05 20:21:43.133  1000   591  1224 D CompatibilityChangeReporter: Compat change id reported: 205907456; UID 10162; state: ENABLED
03-05 20:21:43.141  1000   591  1224 D CompatibilityChangeReporter: Compat change id reported: 194833441; UID 10162; state: ENABLED
03-05 20:21:43.152  1000   591   651 D CoreBackPreview: Window{f166d63 u0 Splash Screen com.example.dat153oblig1}: Setting back callback OnBackInvokedCallbackInfo{mCallback=android.window.IOnBackInvokedCallback$Stub$Proxy@828219, mPriority=0}
03-05 20:21:43.165  1000   416   461 D goldfish-address-space: claimShared: Ask to claim region [0x3f07e9000 0x3f0fd2000]
03-05 20:21:43.178  1000   416   461 D goldfish-address-space: claimShared: Ask to claim region [0x3f0fd2000 0x3f17bb000]
03-05 20:21:43.180  1000   416   461 D goldfish-address-space: claimShared: Ask to claim region [0x3f17bb000 0x3f1fa4000]
03-05 20:21:43.191 10142   875   976 W Parcel  : Expecting binder but got null!
03-05 20:21:43.202 10162 14799 14825 D libEGL  : loaded /vendor/lib64/egl/libEGL_emulation.so
03-05 20:21:43.210 10162 14799 14825 D libEGL  : loaded /vendor/lib64/egl/libGLESv1_CM_emulation.so
03-05 20:21:43.215 10162 14799 14825 D libEGL  : loaded /vendor/lib64/egl/libGLESv2_emulation.so
03-05 20:21:43.228 10139  1154  1641 D EGL_emulation: app_time_stats: avg=32821.68ms min=32821.68ms max=32821.68ms count=1
03-05 20:21:43.278 10107  2392  2392 I GsaVoiceInteractionSrv: Handling ACTION_STOP_HOTWORD
03-05 20:21:43.284 10107  2392  2787 E HwDetectorWithState: a: 3
03-05 20:21:43.292 10162 14799 14799 D LifecycleMonitor: Lifecycle status change: com.example.dat153oblig1.DatabaseActivity@9cc935 in: PRE_ON_CREATE
03-05 20:21:43.293 10162 14799 14799 V ActivityScenario: Activity lifecycle changed event received but ignored because the reported transition was not ON_CREATE while the last known transition was PRE_ON_CREATE
03-05 20:21:43.363 10162 14799 14799 W le.dat153oblig1: Accessing hidden method Landroid/view/View;->computeFitSystemWindows(Landroid/graphics/Rect;Landroid/graphics/Rect;)Z (unsupported, reflection, allowed)
03-05 20:21:43.364 10162 14799 14799 W le.dat153oblig1: Accessing hidden method Landroid/view/ViewGroup;->makeOptionalFitsSystemWindows()V (unsupported, reflection, allowed)
03-05 20:21:43.367 10162 14799 14799 D CompatibilityChangeReporter: Compat change id reported: 210923482; UID 10162; state: ENABLED
03-05 20:21:43.467 10162 14799 14799 D LifecycleMonitor: Lifecycle status change: com.example.dat153oblig1.DatabaseActivity@9cc935 in: CREATED
03-05 20:21:43.468 10162 14799 14799 V ActivityScenario: Update currentActivityStage to CREATED, currentActivity=com.example.dat153oblig1.DatabaseActivity@9cc935
03-05 20:21:43.470 10162 14799 14799 D LifecycleMonitor: Lifecycle status change: com.example.dat153oblig1.DatabaseActivity@9cc935 in: STARTED
03-05 20:21:43.470 10162 14799 14799 V ActivityScenario: Update currentActivityStage to STARTED, currentActivity=com.example.dat153oblig1.DatabaseActivity@9cc935
03-05 20:21:43.475 10162 14799 14799 D LifecycleMonitor: Lifecycle status change: com.example.dat153oblig1.DatabaseActivity@9cc935 in: RESUMED
03-05 20:21:43.476 10162 14799 14799 V ActivityScenario: Update currentActivityStage to RESUMED, currentActivity=com.example.dat153oblig1.DatabaseActivity@9cc935
03-05 20:21:43.510  1000   591  1224 D CoreBackPreview: Window{ae8c9a7 u0 com.example.dat153oblig1/com.example.dat153oblig1.DatabaseActivity}: Setting back callback OnBackInvokedCallbackInfo{mCallback=android.window.IOnBackInvokedCallback$Stub$Proxy@5341fd, mPriority=0}
03-05 20:21:43.519  1000   591   651 W ActivityManager: Unable to start service Intent { act=android.service.smartspace.SmartspaceService cmp=com.google.android.as/com.google.android.apps.miphone.aiai.app.AiAiSmartspaceService } U=0: not found
03-05 20:21:43.520  1000   591   651 W RemoteSmartspaceService: could not bind to Intent { act=android.service.smartspace.SmartspaceService cmp=com.google.android.as/com.google.android.apps.miphone.aiai.app.AiAiSmartspaceService } using flags 67112961
03-05 20:21:43.525  1000   591   591 W ActivityManager: Unbind failed: could not find connection for android.app.LoadedApk$ServiceDispatcher$InnerConnection@7ce5943
03-05 20:21:43.551 10162 14799 14799 E RecyclerView: No adapter attached; skipping layout
03-05 20:21:43.553 10162 14799 14822 D HostConnection: createUnique: call
03-05 20:21:43.555 10162 14799 14822 D HostConnection: HostConnection::get() New Host Connection established 0x7ae9b4f923d0, tid 14822
03-05 20:21:43.577 10162 14799 14822 D HostConnection: HostComposition ext ANDROID_EMU_CHECKSUM_HELPER_v1 ANDROID_EMU_native_sync_v2 ANDROID_EMU_native_sync_v3 ANDROID_EMU_native_sync_v4 ANDROID_EMU_dma_v1 ANDROID_EMU_direct_mem ANDROID_EMU_host_composition_v1 ANDROID_EMU_host_composition_v2 ANDROID_EMU_YUV_Cache ANDROID_EMU_has_shared_slots_host_memory_allocator ANDROID_EMU_sync_buffer_data ANDROID_EMU_read_color_buffer_dma GL_OES_EGL_image_external_essl3 GL_OES_vertex_array_object GL_KHR_texture_compression_astc_ldr ANDROID_EMU_host_side_tracing ANDROID_EMU_gles_max_version_3_0
03-05 20:21:43.580 10162 14799 14822 W OpenGLRenderer: Failed to choose config with EGL_SWAP_BEHAVIOR_PRESERVED, retrying without...
03-05 20:21:43.580 10162 14799 14822 W OpenGLRenderer: Failed to initialize 101010-2 format, error = EGL_SUCCESS
03-05 20:21:43.581 10162 14799 14822 D EGL_emulation: eglCreateContext: 0x7ae9b4f90ed0: maj 3 min 0 rcv 3
03-05 20:21:43.584 10162 14799 14822 D EGL_emulation: eglMakeCurrent: 0x7ae9b4f90ed0: ver 3 0 (tinfo 0x7aebd561f080) (first time)
03-05 20:21:43.596  1000   237   237 I hwservicemanager: getTransport: Cannot find entry android.hardware.graphics.mapper@4.0::IMapper/default in either framework or device VINTF manifest.
03-05 20:21:43.596 10162 14799 14822 I Gralloc4: mapper 4.x is not supported
03-05 20:21:43.597 10162 14799 14822 D HostConnection: createUnique: call
03-05 20:21:43.598 10162 14799 14822 D HostConnection: HostConnection::get() New Host Connection established 0x7ae9b4f92e50, tid 14822
03-05 20:21:43.599 10162 14799 14822 D goldfish-address-space: allocate: Ask for block of size 0x100
03-05 20:21:43.599 10162 14799 14822 D goldfish-address-space: allocate: ioctl allocate returned offset 0x3efffe000 size 0x2000
03-05 20:21:43.602  1000   237   237 I hwservicemanager: getTransport: Cannot find entry android.hardware.graphics.allocator@4.0::IAllocator/default in either framework or device VINTF manifest.
03-05 20:21:43.603  1000   236   236 I servicemanager: Could not find android.hardware.graphics.allocator.IAllocator/default in the VINTF manifest.
03-05 20:21:43.604 10162 14799 14822 W Gralloc4: allocator 4.x is not supported
03-05 20:21:43.606  1000   416   461 D goldfish-address-space: claimShared: Ask to claim region [0x3f1fa4000 0x3f278d000]
03-05 20:21:43.623 10162 14799 14822 D HostConnection: HostComposition ext ANDROID_EMU_CHECKSUM_HELPER_v1 ANDROID_EMU_native_sync_v2 ANDROID_EMU_native_sync_v3 ANDROID_EMU_native_sync_v4 ANDROID_EMU_dma_v1 ANDROID_EMU_direct_mem ANDROID_EMU_host_composition_v1 ANDROID_EMU_host_composition_v2 ANDROID_EMU_YUV_Cache ANDROID_EMU_has_shared_slots_host_memory_allocator ANDROID_EMU_sync_buffer_data ANDROID_EMU_read_color_buffer_dma GL_OES_EGL_image_external_essl3 GL_OES_vertex_array_object GL_KHR_texture_compression_astc_ldr ANDROID_EMU_host_side_tracing ANDROID_EMU_gles_max_version_3_0
03-05 20:21:43.626  1000   416   461 D goldfish-address-space: claimShared: Ask to claim region [0x3f278d000 0x3f2f76000]
03-05 20:21:43.627  1000   416   461 D goldfish-address-space: claimShared: Ask to claim region [0x3f2f76000 0x3f375f000]
03-05 20:21:43.721 10162 14799 14822 W Parcel  : Expecting binder but got null!
03-05 20:21:43.728  1000   591   607 W ziparchive: Unable to open '/data/app/~~R3nPnbMu5wwePav2oXYyJw==/com.example.dat153oblig1-UKJaxg1A1ygsxrDOsRZT2g==/base.dm': No such file or directory
03-05 20:21:43.729  1000   591   607 I ActivityTaskManager: Displayed com.example.dat153oblig1/.DatabaseActivity: +607ms
03-05 20:21:43.767 10142   875   976 D EGL_emulation: app_time_stats: avg=12464.71ms min=12464.71ms max=12464.71ms count=1
03-05 20:21:43.855  1000   591   651 D CompatibilityChangeReporter: Compat change id reported: 214016041; UID 10162; state: ENABLED
03-05 20:21:43.878 10130  9734  9734 I GoogleInputMethodService: GoogleInputMethodService.onFinishInput():3220... (7 KB left)
```
