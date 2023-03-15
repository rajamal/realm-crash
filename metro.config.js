/**
 * Metro configuration for React Native
 * https://github.com/facebook/react-native
 *
 * @format
 */

const exclusionList = require('metro-config/src/defaults/exclusionList');

module.exports = {
    transformer: {
        getTransformOptions: async () => ({
            transform: {
                experimentalImportSupport: false,
                inlineRequires: true
            }
        })
    },
    resolver: {
        sourceExts: ['jsx', 'js', 'ts', 'tsx'], //add here
        blacklistRE: exclusionList([
            /ios\/Pods\/JitsiMeetSDK\/Frameworks\/JitsiMeet.framework\/assets\/node_modules\/react-native\/.*/,
            /app\/.*/
        ])
    }
};
