import { useNavigation } from '@react-navigation/native';
import React from 'react';
import { StyleSheet, Text, View, Image } from 'react-native';
import { TouchableNativeFeedback } from 'react-native-gesture-handler';

export default function Header() {
  const navigation = useNavigation()

  const handleOnPress = () => {
    navigation.navigate("Home")
  }

  return (
    <TouchableNativeFeedback onPress={handleOnPress}>
      <View style={styles.container}>
        <Image source={require('../assets/logo.png')} />
          <Text style={styles.text}>DS Delivery</Text>
      </View>
    </TouchableNativeFeedback>
  );
}

