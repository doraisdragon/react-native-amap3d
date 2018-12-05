import { NativeModules } from 'react-native'
import { LatLng } from './PropTypes'
const { AMapUtil } = NativeModules

export default {
  async converter(coordinate: LatLng) {
    if(coordinate && coordinate.latitude&&coordinate.longitude){
      let returnData = await AMapUtil.converter({
        latitude:Number(coordinate.latitude),
        longitude:Number(coordinate.longitude)
      })
      return returnData
    } else {
      return false
    }
  },
}