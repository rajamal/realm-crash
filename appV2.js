import React from 'react';
import { View } from "react-native";
import SplashScreen from 'react-native-splash-screen';

export default function App() {
    SplashScreen.hide();
    return <View style={{backgroundColor: "red", flex: 1}} />;
}