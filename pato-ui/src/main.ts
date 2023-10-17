import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import {registerLicense} from '@syncfusion/ej2-base';
import { AppModule } from './app/app.module';
import { environment } from './environments/environment';
registerLicense("Mgo+DSMBaFt+QHJqVk1hXk5Hd0BLVGpAblJ3T2ZQdVt5ZDU7a15RRnVfR1xiSH5WcUFnXndXcQ==;Mgo+DSMBPh8sVXJ1S0R+X1pFdEBBXHxAd1p/VWJYdVt5flBPcDwsT3RfQF5jTH9Sd0VmXntaeHRWRw==;ORg4AjUWIQA/Gnt2VFhiQlJPd11dXmJWd1p/THNYflR1fV9DaUwxOX1dQl9gSXtSd0RjXHhadHxUQ2E=;MjAxMTA1NEAzMjMxMmUzMjJlMzNseHFTVTRRcXdsdXJmaURudTBxeFRYU1N3Tm9GUlFvaExZdFdKWFNNMm80PQ==;MjAxMTA1NUAzMjMxMmUzMjJlMzNiSmU4RjY2M3ZMV3YrMWdXM1IrbHE0dlh5NmxQeWgvS2RjNjdMSE9CaGxBPQ==;NRAiBiAaIQQuGjN/V0d+Xk9HfV5AQmBIYVp/TGpJfl96cVxMZVVBJAtUQF1hSn5Wd0RiWXpZdHBdQWZd;MjAxMTA1N0AzMjMxMmUzMjJlMzNmWkFvLzlqaTMwRkhGT1AwbzRaS09hQ3lzTU43KzRXUENPRVh2b0dNUnVVPQ==;MjAxMTA1OEAzMjMxMmUzMjJlMzNlbG1XenY1VTdrVGJtVnBLclhQbUN2OGVlL0dDV29UQStpc05MK25sMDlFPQ==;Mgo+DSMBMAY9C3t2VFhiQlJPd11dXmJWd1p/THNYflR1fV9DaUwxOX1dQl9gSXtSd0RjXHhadH1RQGE=;MjAxMTA2MEAzMjMxMmUzMjJlMzNGeDFNeFR6cWRIV1p2SEYrSThIK0o4RTk1YTczL3AydjB0Vm9WeWwzMUNrPQ==;MjAxMTA2MUAzMjMxMmUzMjJlMzNHOTZNb2J5VE1ldFpJaXhnZ3RDN1MxZjExd1dvdFR6TnRBckFHVmhxUTc0PQ==;MjAxMTA2MkAzMjMxMmUzMjJlMzNmWkFvLzlqaTMwRkhGT1AwbzRaS09hQ3lzTU43KzRXUENPRVh2b0dNUnVVPQ==");
if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
