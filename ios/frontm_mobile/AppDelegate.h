/**
 * Copyright (c) 2015-present, Facebook, Inc.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

#import <React/RCTBridgeDelegate.h>
#import <PushKit/PushKit.h>
#import <UIKit/UIKit.h>

@interface AppDelegate : UIResponder <UIApplicationDelegate, RCTBridgeDelegate, PKPushRegistryDelegate>

@property (nonatomic, strong) UIWindow *window;
@property (nonatomic) NSString *voipToken;
@property (nonatomic) NSString *callID;
@property (nonatomic) NSString *callSession;

@end
