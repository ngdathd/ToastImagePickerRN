/* eslint-disable no-undef */
/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, { Component } from 'react';
import {
    View,
    Button,
    NativeModules
} from 'react-native';

const { ToastModule, ImagePickerModule } = NativeModules;

class App extends Component {
    _onPressButton() {
        ToastModule.showText('This is Android', ToastModule.LENGTH_SHORT);
    }

    _onOpenGalary() {
        ImagePickerModule.openGallery();
    }

    render() {
        return (
            <View style={{ flex: 1, justifyContent: 'center' }}>
                <Button style={{ flex: 1, justifyContent: 'center' }}
                    onPress={this._onPressButton}
                    title='RN calls Toast'
                />
                <Button style={{ flex: 1, justifyContent: 'center' }}
                    onPress={this._onOpenGalary}
                    title='RN calls Galary'
                />
            </View>
        );
    }
}

export default App;
