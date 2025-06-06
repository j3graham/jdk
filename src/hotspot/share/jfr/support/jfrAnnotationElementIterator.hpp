/*
* Copyright (c) 2016, 2025, Oracle and/or its affiliates. All rights reserved.
* DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
*
* This code is free software; you can redistribute it and/or modify it
* under the terms of the GNU General Public License version 2 only, as
* published by the Free Software Foundation.
*
* This code is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
* FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
* version 2 for more details (a copy is included in the LICENSE file that
* accompanied this code).
*
* You should have received a copy of the GNU General Public License version
* 2 along with this work; if not, write to the Free Software Foundation,
* Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
*
* Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
* or visit www.oracle.com if you need additional information or have any
* questions.
*
*/

#ifndef SHARE_JFR_SUPPORT_JFRANNOTATIONELEMENTITERATOR_HPP
#define SHARE_JFR_SUPPORT_JFRANNOTATIONELEMENTITERATOR_HPP

#include "jni.h"
#include "utilities/globalDefinitions.hpp"
#include "memory/allocation.hpp"

class InstanceKlass;
class Symbol;

class JfrAnnotationElementIterator : public StackObj {
 private:
  const InstanceKlass* _ik;
  const address _buffer;
  const int _limit; // length of annotation
  mutable int _current; // element
  mutable int _next; // element
  int value_index() const;

 public:
  JfrAnnotationElementIterator(const InstanceKlass* ik, address buffer, int limit);
  bool has_next() const;
  void move_to_next() const;
  int number_of_elements() const;
  bool read_bool() const;
  jint read_int() const;
  char value_type() const;
  const Symbol* name() const;
};

#endif // SHARE_JFR_SUPPORT_JFRANNOTATIONELEMENTITERATOR_HPP
