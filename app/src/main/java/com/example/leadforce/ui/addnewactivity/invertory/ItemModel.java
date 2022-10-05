package com.example.leadforce.ui.addnewactivity.invertory;

import java.io.Serializable;

public class ItemModel  implements Serializable {
 String name;
 int icon;

 public ItemModel() {

 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public int getIcon() {
  return icon;
 }

 public void setIcon(int icon) {
  this.icon = icon;
 }
}
