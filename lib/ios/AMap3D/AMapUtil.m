#import <MAMapKit/MAMapKit.h>
#import <React/RCTBridgeModule.h>

@interface AMapUtil : NSObject<RCTBridgeModule>

@end

@implementation AMapUtil

RCT_EXPORT_MODULE()


RCT_EXPORT_METHOD(converter:(NSDictionary *)coordinate
                 resolver:(RCTPromiseResolveBlock)resolve
                 rejecter:(RCTPromiseRejectBlock)reject) {
    CLLocationCoordinate2D returnCoor = AMapCoordinateConvert(CLLocationCoordinate2DMake([coordinate[@"latitude"] doubleValue],[coordinate[@"longitude"] doubleValue]), 1);
    resolve(@{
            @"latitude": @(returnCoor.latitude),
            @"longitude": @(returnCoor.longitude),
        });
}

@end