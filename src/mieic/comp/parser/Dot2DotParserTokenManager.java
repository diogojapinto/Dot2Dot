/* Generated By:JJTree&JavaCC: Do not edit this line. Dot2DotParserTokenManager.java */
package mieic.comp.parser;
import java.io.*;
import mieic.comp.graph.Graph;
import mieic.comp.parser.ASTGraph.GraphType;

/** Token Manager. */
public class Dot2DotParserTokenManager implements Dot2DotParserConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x10L) != 0L)
            return 0;
         if ((active0 & 0x18000L) != 0L)
            return 109;
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 10:
         return jjStartNfaWithStates_0(0, 4, 0);
      case 44:
         return jjStopAtPos(0, 31);
      case 45:
         return jjMoveStringLiteralDfa1_0(0x18000L);
      case 58:
         return jjStopAtPos(0, 28);
      case 59:
         return jjStopAtPos(0, 26);
      case 61:
         return jjStopAtPos(0, 27);
      case 91:
         return jjStopAtPos(0, 29);
      case 93:
         return jjStopAtPos(0, 30);
      case 123:
         return jjStopAtPos(0, 24);
      case 125:
         return jjStopAtPos(0, 25);
      default :
         return jjMoveNfa_0(3, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 45:
         if ((active0 & 0x10000L) != 0L)
            return jjStopAtPos(1, 16);
         break;
      case 62:
         if ((active0 & 0x8000L) != 0L)
            return jjStopAtPos(1, 15);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 109;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 109:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 17)
                        kind = 17;
                     jjCheckNAddTwoStates(55, 56);
                  }
                  else if (curChar == 46)
                     jjCheckNAdd(54);
                  break;
               case 3:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 17)
                        kind = 17;
                     jjCheckNAddTwoStates(55, 56);
                  }
                  else if (curChar == 47)
                     jjAddStates(0, 1);
                  else if (curChar == 60)
                     jjCheckNAddTwoStates(59, 63);
                  else if (curChar == 46)
                     jjCheckNAdd(54);
                  else if (curChar == 45)
                     jjCheckNAddTwoStates(53, 55);
                  else if (curChar == 34)
                     jjCheckNAddStates(2, 4);
                  else if (curChar == 35)
                  {
                     if (kind > 7)
                        kind = 7;
                     jjCheckNAddStates(5, 7);
                  }
                  else if (curChar == 10)
                     jjstateSet[jjnewStateCnt++] = 0;
                  break;
               case 0:
                  if (curChar == 29)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 1:
                  if ((0xfffffffffffffbffL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 2:
                  if (curChar == 10 && kind > 3)
                     kind = 3;
                  break;
               case 4:
                  if (curChar != 35)
                     break;
                  if (kind > 7)
                     kind = 7;
                  jjCheckNAddStates(5, 7);
                  break;
               case 5:
                  if ((0xffffffffffffdbffL & l) == 0L)
                     break;
                  if (kind > 7)
                     kind = 7;
                  jjCheckNAddStates(5, 7);
                  break;
               case 6:
                  if ((0x2400L & l) != 0L && kind > 7)
                     kind = 7;
                  break;
               case 7:
                  if (curChar == 10 && kind > 7)
                     kind = 7;
                  break;
               case 8:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 46:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjstateSet[jjnewStateCnt++] = 46;
                  break;
               case 47:
               case 48:
                  if (curChar == 34)
                     jjCheckNAddStates(2, 4);
                  break;
               case 50:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     jjCheckNAddStates(2, 4);
                  break;
               case 51:
                  if (curChar == 34 && kind > 17)
                     kind = 17;
                  break;
               case 52:
                  if (curChar == 45)
                     jjCheckNAddTwoStates(53, 55);
                  break;
               case 53:
                  if (curChar == 46)
                     jjCheckNAdd(54);
                  break;
               case 54:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAdd(54);
                  break;
               case 55:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAddTwoStates(55, 56);
                  break;
               case 56:
                  if (curChar == 46)
                     jjCheckNAdd(57);
                  break;
               case 57:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAdd(57);
                  break;
               case 58:
                  if (curChar == 60)
                     jjCheckNAddTwoStates(59, 63);
                  break;
               case 59:
                  if (curChar == 60)
                     jjCheckNAddTwoStates(60, 61);
                  break;
               case 60:
                  if ((0xbfffffffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(60, 61);
                  break;
               case 61:
                  if (curChar == 62)
                     jjCheckNAddStates(8, 10);
                  break;
               case 62:
                  if ((0xafffffffffffffffL & l) != 0L)
                     jjCheckNAddStates(8, 10);
                  break;
               case 63:
                  if (curChar == 62 && kind > 17)
                     kind = 17;
                  break;
               case 65:
                  if (curChar == 47)
                     jjAddStates(0, 1);
                  break;
               case 66:
                  if (curChar != 47)
                     break;
                  if (kind > 6)
                     kind = 6;
                  jjCheckNAddStates(11, 13);
                  break;
               case 67:
                  if ((0xffffffffffffdbffL & l) == 0L)
                     break;
                  if (kind > 6)
                     kind = 6;
                  jjCheckNAddStates(11, 13);
                  break;
               case 68:
                  if ((0x2400L & l) != 0L && kind > 6)
                     kind = 6;
                  break;
               case 69:
                  if (curChar == 10 && kind > 6)
                     kind = 6;
                  break;
               case 70:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 69;
                  break;
               case 71:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(72, 73);
                  break;
               case 72:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(72, 73);
                  break;
               case 73:
                  if (curChar == 42)
                     jjAddStates(14, 15);
                  break;
               case 74:
                  if ((0xffff7fffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(75, 73);
                  break;
               case 75:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(75, 73);
                  break;
               case 76:
                  if (curChar == 47 && kind > 8)
                     kind = 8;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 3:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 17)
                        kind = 17;
                     jjCheckNAdd(46);
                  }
                  if ((0x88402880000000L & l) != 0L)
                  {
                     if (kind > 23)
                        kind = 23;
                  }
                  else if (curChar == 83)
                     jjAddStates(16, 17);
                  else if (curChar == 69)
                     jjstateSet[jjnewStateCnt++] = 43;
                  else if (curChar == 78)
                     jjstateSet[jjnewStateCnt++] = 35;
                  else if (curChar == 68)
                     jjstateSet[jjnewStateCnt++] = 31;
                  else if (curChar == 100)
                     jjstateSet[jjnewStateCnt++] = 24;
                  else if (curChar == 71)
                     jjstateSet[jjnewStateCnt++] = 17;
                  else if (curChar == 103)
                     jjstateSet[jjnewStateCnt++] = 12;
                  if (curChar == 110)
                     jjCheckNAddStates(18, 20);
                  else if (curChar == 115)
                     jjCheckNAddStates(21, 24);
                  else if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 39;
                  break;
               case 1:
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 5:
                  if (kind > 7)
                     kind = 7;
                  jjAddStates(5, 7);
                  break;
               case 9:
                  if (curChar == 104 && kind > 10)
                     kind = 10;
                  break;
               case 10:
                  if (curChar == 112)
                     jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 11:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 10;
                  break;
               case 12:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 13:
                  if (curChar == 103)
                     jjstateSet[jjnewStateCnt++] = 12;
                  break;
               case 14:
                  if (curChar == 72 && kind > 10)
                     kind = 10;
                  break;
               case 15:
                  if (curChar == 80)
                     jjstateSet[jjnewStateCnt++] = 14;
                  break;
               case 16:
                  if (curChar == 65)
                     jjstateSet[jjnewStateCnt++] = 15;
                  break;
               case 17:
                  if (curChar == 82)
                     jjstateSet[jjnewStateCnt++] = 16;
                  break;
               case 18:
                  if (curChar == 71)
                     jjstateSet[jjnewStateCnt++] = 17;
                  break;
               case 19:
                  if (curChar == 104 && kind > 11)
                     kind = 11;
                  break;
               case 20:
                  if (curChar == 112)
                     jjstateSet[jjnewStateCnt++] = 19;
                  break;
               case 21:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 20;
                  break;
               case 22:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 21;
                  break;
               case 23:
                  if (curChar == 103)
                     jjstateSet[jjnewStateCnt++] = 22;
                  break;
               case 24:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 23;
                  break;
               case 25:
                  if (curChar == 100)
                     jjstateSet[jjnewStateCnt++] = 24;
                  break;
               case 26:
                  if (curChar == 72 && kind > 11)
                     kind = 11;
                  break;
               case 27:
                  if (curChar == 80)
                     jjstateSet[jjnewStateCnt++] = 26;
                  break;
               case 28:
                  if (curChar == 65)
                     jjstateSet[jjnewStateCnt++] = 27;
                  break;
               case 29:
                  if (curChar == 82)
                     jjstateSet[jjnewStateCnt++] = 28;
                  break;
               case 30:
                  if (curChar == 71)
                     jjstateSet[jjnewStateCnt++] = 29;
                  break;
               case 31:
                  if (curChar == 73)
                     jjstateSet[jjnewStateCnt++] = 30;
                  break;
               case 32:
                  if (curChar == 68)
                     jjstateSet[jjnewStateCnt++] = 31;
                  break;
               case 33:
                  if (curChar == 69 && kind > 12)
                     kind = 12;
                  break;
               case 34:
                  if (curChar == 68)
                     jjstateSet[jjnewStateCnt++] = 33;
                  break;
               case 35:
                  if (curChar == 79)
                     jjstateSet[jjnewStateCnt++] = 34;
                  break;
               case 36:
                  if (curChar == 78)
                     jjstateSet[jjnewStateCnt++] = 35;
                  break;
               case 37:
                  if (curChar == 101 && kind > 13)
                     kind = 13;
                  break;
               case 38:
                  if (curChar == 103)
                     jjstateSet[jjnewStateCnt++] = 37;
                  break;
               case 39:
                  if (curChar == 100)
                     jjstateSet[jjnewStateCnt++] = 38;
                  break;
               case 40:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 39;
                  break;
               case 41:
                  if (curChar == 69 && kind > 13)
                     kind = 13;
                  break;
               case 42:
                  if (curChar == 71)
                     jjstateSet[jjnewStateCnt++] = 41;
                  break;
               case 43:
                  if (curChar == 68)
                     jjstateSet[jjnewStateCnt++] = 42;
                  break;
               case 44:
                  if (curChar == 69)
                     jjstateSet[jjnewStateCnt++] = 43;
                  break;
               case 45:
               case 46:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAdd(46);
                  break;
               case 49:
                  if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 48;
                  break;
               case 50:
                  jjAddStates(2, 4);
                  break;
               case 60:
                  jjAddStates(25, 26);
                  break;
               case 62:
                  jjAddStates(8, 10);
                  break;
               case 64:
                  if ((0x88402880000000L & l) != 0L && kind > 23)
                     kind = 23;
                  break;
               case 67:
                  if (kind > 6)
                     kind = 6;
                  jjAddStates(11, 13);
                  break;
               case 72:
                  jjCheckNAddTwoStates(72, 73);
                  break;
               case 74:
               case 75:
                  jjCheckNAddTwoStates(75, 73);
                  break;
               case 77:
                  if (curChar == 115)
                     jjCheckNAddStates(21, 24);
                  break;
               case 78:
                  if (curChar == 116 && kind > 9)
                     kind = 9;
                  break;
               case 79:
                  if (curChar == 99)
                     jjstateSet[jjnewStateCnt++] = 78;
                  break;
               case 80:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 79;
                  break;
               case 81:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 80;
                  break;
               case 82:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 81;
                  break;
               case 83:
                  if (curChar == 104 && kind > 14)
                     kind = 14;
                  break;
               case 84:
                  if (curChar == 112)
                     jjstateSet[jjnewStateCnt++] = 83;
                  break;
               case 85:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 84;
                  break;
               case 86:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 85;
                  break;
               case 87:
                  if (curChar == 103)
                     jjstateSet[jjnewStateCnt++] = 86;
                  break;
               case 88:
                  if (curChar == 98)
                     jjstateSet[jjnewStateCnt++] = 87;
                  break;
               case 89:
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 88;
                  break;
               case 90:
                  if (curChar == 119 && kind > 23)
                     kind = 23;
                  break;
               case 91:
                  if (curChar == 101 && kind > 23)
                     kind = 23;
                  break;
               case 92:
                  if (curChar == 83)
                     jjAddStates(16, 17);
                  break;
               case 93:
                  if (curChar == 84 && kind > 9)
                     kind = 9;
                  break;
               case 94:
                  if (curChar == 67)
                     jjstateSet[jjnewStateCnt++] = 93;
                  break;
               case 95:
                  if (curChar == 73)
                     jjstateSet[jjnewStateCnt++] = 94;
                  break;
               case 96:
                  if (curChar == 82)
                     jjstateSet[jjnewStateCnt++] = 95;
                  break;
               case 97:
                  if (curChar == 84)
                     jjstateSet[jjnewStateCnt++] = 96;
                  break;
               case 98:
                  if (curChar == 72 && kind > 14)
                     kind = 14;
                  break;
               case 99:
                  if (curChar == 80)
                     jjstateSet[jjnewStateCnt++] = 98;
                  break;
               case 100:
                  if (curChar == 65)
                     jjstateSet[jjnewStateCnt++] = 99;
                  break;
               case 101:
                  if (curChar == 82)
                     jjstateSet[jjnewStateCnt++] = 100;
                  break;
               case 102:
                  if (curChar == 71)
                     jjstateSet[jjnewStateCnt++] = 101;
                  break;
               case 103:
                  if (curChar == 66)
                     jjstateSet[jjnewStateCnt++] = 102;
                  break;
               case 104:
                  if (curChar == 85)
                     jjstateSet[jjnewStateCnt++] = 103;
                  break;
               case 105:
                  if (curChar == 110)
                     jjCheckNAddStates(18, 20);
                  break;
               case 106:
                  if (curChar == 101 && kind > 12)
                     kind = 12;
                  break;
               case 107:
                  if (curChar == 100)
                     jjstateSet[jjnewStateCnt++] = 106;
                  break;
               case 108:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 107;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 3:
               case 46:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAdd(46);
                  break;
               case 1:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 5:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 7)
                     kind = 7;
                  jjAddStates(5, 7);
                  break;
               case 50:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(2, 4);
                  break;
               case 60:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(25, 26);
                  break;
               case 62:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(8, 10);
                  break;
               case 67:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 6)
                     kind = 6;
                  jjAddStates(11, 13);
                  break;
               case 72:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(72, 73);
                  break;
               case 74:
               case 75:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(75, 73);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 109 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   66, 71, 49, 50, 51, 5, 6, 8, 59, 62, 63, 67, 68, 70, 74, 76, 
   97, 104, 108, 90, 91, 82, 89, 90, 91, 60, 61, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, "\55\76", "\55\55", null, null, null, null, null, null, null, "\173", 
"\175", "\73", "\75", "\72", "\133", "\135", "\54", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0xff83fe01L, 
};
static final long[] jjtoSkip = {
   0x1feL, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[109];
private final int[] jjstateSet = new int[218];
protected char curChar;
/** Constructor. */
public Dot2DotParserTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public Dot2DotParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 109; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002200L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
