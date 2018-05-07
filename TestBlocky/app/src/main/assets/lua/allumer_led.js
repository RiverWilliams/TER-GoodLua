Blockly.Lua['allumer_led'] = function(block) {
  var value_red = Blockly.Lua.valueToCode(block, 'red', Blockly.Lua.ORDER_ATOMIC);
  var value_green = Blockly.Lua.valueToCode(block, 'green', Blockly.Lua.ORDER_ATOMIC);
  var value_blue = Blockly.Lua.valueToCode(block, 'blue', Blockly.Lua.ORDER_ATOMIC);
  // TODO: Assemble Lua into code variable.
  var code = 'print("aaaaaaaaaaaaaaa");';
  return code;
};

Blockly.Lua['pin'] = function(block) {
  var number_num_pin = block.getFieldValue('num_pin');
  var number_valeur_pin = block.getFieldValue('valeur_pin');
  // TODO: Assemble Lua into code variable.
  var code = 'print("bbbbbbbbbbbbbbbbbb");';
  // TODO: Change ORDER_NONE to the correct strength.
  return [code, Blockly.Lua.ORDER_NONE];
};